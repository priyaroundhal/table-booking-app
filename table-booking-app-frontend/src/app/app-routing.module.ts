import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TableListComponent } from './component/table-list/table-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'tables', pathMatch: 'full' },
  {path: 'tables', component: TableListComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
