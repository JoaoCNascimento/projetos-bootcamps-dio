import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Room } from 'src/app/models/room';
import { RoomService } from 'src/app/services/room.service';

@Component({
  selector: 'app-update-room',
  templateUrl: './update-room.component.html',
  styleUrls: ['./update-room.component.css']
})
export class UpdateRoomComponent implements OnInit {

  id: number;
  room: Room;
  submitted: boolean = false;

  constructor(
    private roomService: RoomService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.room = new Room();

    this.id = this.route.snapshot.params['id'];

    this.roomService.getRoomById(this.id).subscribe(
      data => { this.room = data; console.log(data) },
      error => console.log(error)
    );
  }

  onSubmit() {
    this.updateRoom();
  }

  updateRoom() {
    this.roomService.updateRoom(this.id, this.room).subscribe(
      data => console.log(data),
      error => console.log(error)
    );
    this.room = new Room();
    this.goToList();
  }

  goToList() {
    this.router.navigate(['/rooms']);
  }
}
