import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; //ngForなどに必要1
import { RouterModule, Routes } from '@angular/router';
import { Router } from "@angular/router";

@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [CommonModule], //ngForなどに必要2
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.css'
})

export class TodoListComponent implements OnInit{

  title : string = 'Todo一覧';
  todos2 = [ {key : '1' , name:'test1'} , {key : '2' , name:'test2'} , {key : '3' , name:'test3'} ];
  objKey : string = '';
  keyNumber : number = 1;
  private router: Router;

  cunstructor(){
    //オブジェクトのキーが一意になるように現在時刻を取得
    const now = new Date();
    this.objKey = now.getTime().toString();
  }

  ngOnInit():void{}

  addTodo(todo:string):void{
    //一意なキーを作成
    this.objKey += this.keyNumber;
    this.keyNumber++;

    //オブジェクトを追加
    this.todos2.push({key:this.objKey , name:todo});

    //入力欄をクリア
    this.clearText();
  }

  //keyを指定して削除(配列を再設定)
  deleteTodo2(deletekey:string):void{
    this.todos2 = this.todos2.filter( obj => obj.key !== deletekey);
  }

  clearText():void{
    const testtest = document.getElementById("input1") as HTMLInputElement //HTMLInputElementで型を明確に指定しないとJSみたいに使用できない。
    testtest.value ='';
  }

  toDetail():void{
    this.router.navigate(["/id"]);
  }

}
