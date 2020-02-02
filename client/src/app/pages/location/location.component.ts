import {Component, OnInit} from '@angular/core';
import { LocationService } from 'src/app/services/location.service';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-location-list',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css'],
})
export class LocationComponent implements OnInit {
  cols = [
    {field: 'id', header: 'ID'},
    {field: 'locationName', header: 'Location Name'},
    {field: 'lat', header: 'Latitude'},
    {field: 'lng', header: 'Longitude'}
  ];
  locations = [];
  address = '';
  display = false;
  deleteConfirm = false;
  form: FormGroup;
  id;

  constructor(private locationsService: LocationService, private fb: FormBuilder) {
    this.form = this.fb.group({
      locationName: [null, Validators.required],
      lat: [null, Validators.required],
      lng: [null, Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadData();
  }

  private loadData: () => void = () => {
    if (!this.address || this.address === '') {
      this.locationsService.list().subscribe((locations: any) => {
        this.locations = locations;
      });
    } else {
      this.locationsService.search(this.address).subscribe((locations: any) => {
        this.locations = locations;
      });
    }
  }

  add() {
    this.display = true;
  }

  edit(id) {
    this.locationsService.findById(id).subscribe(e => {
      this.id = id;
      this.form.patchValue(e);
      this.display = true;
    });
  }

  save() {
    const body = this.form.getRawValue();
    let request;
    if (this.id) {
      request = this.locationsService.update(this.id, body);
    } else {
      request = this.locationsService.create(body);
    }
    request.subscribe(e => {
      this.id = null;
      this.display = false;
      this.loadData();
      this.form.reset();
    });
  }

  delete(id) {
    this.id = id;
    this.deleteConfirm = true;
  }

  confirmDelete() {
    this.locationsService.delete(this.id).subscribe(e => {
      this.deleteConfirm = false;
      this.loadData();
    });
  }
}

