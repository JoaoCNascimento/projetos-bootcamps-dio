import { Component, OnInit } from '@angular/core';
import { RoomService } from 'src/app/services/room.service';
import { Room } from 'src/app/models/room';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.css']
})
export class CreateRoomComponent implements OnInit {

  room: Room = new Room();
  submitted: boolean = false;

  constructor(
    private roomService: RoomService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  save() {
    this.roomService.createRoom(this.room)
      .subscribe(
        data => console.log(data),
        error => console.log(error)
      );
    this.room = new Room();
    this.goToList();

  }

  newRoom() {
    this.submitted = false;
    this.room = new Room();
  }

  goToList() {
    this.router.navigate(['/rooms']);
  }

}
