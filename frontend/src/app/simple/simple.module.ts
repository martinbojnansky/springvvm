import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SimpleRoutingModule } from './simple-routing.module';
import { SimpleComponent } from './simple.component';
import { SimpleViewModel } from './api/springvvm-simple';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    SimpleComponent
  ],
  imports: [
    CommonModule,
    SimpleRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [SimpleViewModel]
})
export class SimpleModule { }
