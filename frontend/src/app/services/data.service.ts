import { Injectable } from '@angular/core';
import { Task } from '../shared/task-model';
import { User } from '../shared/user-model';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private apiUrl = "http://localhost:8080/taskmanager/api";

  async getTasks(): Promise<Task[]> {
    try {
      const response: Response = await fetch(this.apiUrl + "/tasks", {
        method: 'GET',
        mode: 'cors',
        headers: {
          'Content-Type': 'application/json'
        }
      });
      const { data }: { data: Task[] } = await response.json();
      return data;
    } catch (error) {
      throw(error);
    }
  }

  async getUsers(): Promise<User[]> {
    try {
      const response: Response = await fetch(this.apiUrl + "/users", {
        method: 'GET',
        mode: 'cors',
        headers: {
          'Content-Type': 'application/json'
        }
      })
      const { data }: { data: User[] } = await response.json();
      return data;
    } catch(error) {
      throw(error);
    }
  }

  async getTasksByUser(userId: number): Promise<Task[]> {
    try {
      const response: Response = await fetch(this.apiUrl + "/tasks/users/" + userId, {
        method: 'GET',
        mode: 'cors',
        headers: {
          'Content-Type': 'application/json'
        }
      })
      const { data }: { data: Task[] } = await response.json();
      return data;
    } catch(error) {
      throw(error);
    }
  }
}
