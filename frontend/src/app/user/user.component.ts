import { Component, EventEmitter, Input, Output } from '@angular/core';
import { User } from '../shared/user-model';

@Component({
  selector: 'app-user',
  standalone: true,
  imports: [],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {
  @Input({required: true}) user!: User;
  @Output() onUserClick = new EventEmitter<number>;

  public emitUserId() {
    this.onUserClick.emit(this.user.id);
  }

  public get imagePath() {
    return "assets/" + this.user.username + ".jpg";
  }
}
