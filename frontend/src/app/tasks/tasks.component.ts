import { Component, Input } from '@angular/core';
import { TaskComponent } from "./task/task.component";
import { DataService } from '../services/data.service';
import { Task } from '../shared/task-model';

@Component({
  selector: 'app-tasks',
  standalone: true,
  imports: [TaskComponent],
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css'
})
export class TasksComponent {
  public tasks: Task[] = [];
  public _userId!: number;
  @Input({required: true}) set userId(value: number) {
    this._userId = value;
    this.getTasksByUser();
  }
  get userId(): number {
    return this._userId;
  }

  constructor(private dataService: DataService) {}

  async getTasksByUser(): Promise<void> {
    try {
      this.tasks = await this.dataService.getTasksByUser(this.userId);
    } catch (error) {
      console.log("Erreur")
    }
  }
}
