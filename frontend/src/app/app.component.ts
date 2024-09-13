import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TaskComponent } from "./tasks/task/task.component";
import { TasksComponent } from "./tasks/tasks.component";
import { HeaderComponent } from './header/header.component';
import { UserComponent } from "./user/user.component";
import { User } from './shared/user-model';
import { DataService } from './services/data.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TaskComponent, TasksComponent, HeaderComponent, UserComponent, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'task-manager';
  public users: User[] = [];
  public userId?: number;

  constructor(private dataService: DataService) {}

  ngOnInit(): void {
    this.getUsers();
  }
  async getUsers(): Promise<void> {
    try {
      this.users = await this.dataService.getUsers()
    } catch (error) {
      console.log("Erreur");
    }
  }

  public get selectedUser() {
    return this.users.find(usr => usr.id === this.userId);
  }

  public getUserId(userId: number) {
    this.userId = userId;
  }
}
