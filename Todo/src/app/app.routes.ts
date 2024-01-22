import { Routes } from '@angular/router';
import {TodoDetailComponent} from './todo-detail/todo-detail.component';

export const routes: Routes = [
    {
        path:':id', 
        component:TodoDetailComponent
    }
];
