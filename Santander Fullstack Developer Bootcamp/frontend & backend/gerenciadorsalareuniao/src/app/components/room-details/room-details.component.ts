import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Room } from 'src/app/models/room';
import { RoomService } from 'src/app/services/room.service';

@Component({
  selector: 'app-room-details',
  templateUrl: './room-details.component.html',
  styleUrls: ['./room-details.component.css']
})
export class RoomDetailsComponent implements OnInit {

  id: number;
  room: Room;
  submitted: boolean = false;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private roomService: RoomService
  ) { }

  ngOnInit(): void {
    this.room = new Room();
    this.id = this.route.snapshot.params['id'];

    this.roomService.getRoomById(this.id).subscribe(
      data => { this.room = data; console.log(data) },
      error => console.log(error)
    )
  }

  list() {
    this.router.navigate(['rooms']);
  }

}
