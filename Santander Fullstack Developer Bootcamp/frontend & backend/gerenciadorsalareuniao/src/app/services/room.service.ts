import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map, catchError, take, tap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Room } from '../models/room';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  baseUrl: string = "http://localhost:8080/api/v1/rooms";

  constructor(
    private http: HttpClient
  ) { }

  getRoomList(): Observable<Room[]> {
    return this.http.get<Room[]>(this.baseUrl);
  }

  getRoomById(id: number): Observable<Room> {
    return this.http.get<Room>(`${this.baseUrl}/${id}`);
  }

  createRoom(room: Room) {
    return this.http.post<Room>(this.baseUrl, room);
  }

  deleteRoom(id: number) {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: "text" });
  }

  updateRoom(id: number, room: Room) {
    return this.http.put(`${this.baseUrl}/${id}`, {
      name: room.name,
      date: room.date,
      startHour: room.startHour,
      endHour: room.endHour
    });
  }
}
