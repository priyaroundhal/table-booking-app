import { Component, OnInit } from '@angular/core';
import { TableService } from 'src/app/services/table.service';

@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css']
})
export class TableListComponent implements OnInit {

  constructor(private tableService: TableService) { }
tables:any[]=[];
  ngOnInit(): void {
      console.log('TableListComponent loaded');

    this.loadTables();
    

    }
     loadTables(){
      this.tableService.getTables()
      .subscribe(data=> {
        console.log("data",data)
        this.tables=data
      })
      
     }
     bookTable(id:number){
      this.tableService.booktable(id).subscribe(response=>{
         console.log(response)

        alert(response.message);
        this.loadTables();
      })
     }
     cancelBooking(id: number){
      this.tableService.cancelBooking(id).subscribe(
        resp=>{
          alert(resp.message);
          this.loadTables();
        }
      );
     }
  }


