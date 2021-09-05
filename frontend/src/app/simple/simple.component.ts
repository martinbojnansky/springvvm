import { Component, OnInit } from '@angular/core';
import { SimpleViewModel, SimpleModel } from './api/springvvm-simple';
import { BehaviorSubject } from 'rxjs';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-simple',
  templateUrl: './simple.component.html',
  styleUrls: ['./simple.component.scss']
})
export class SimpleComponent implements OnInit {
  readonly model$ = new BehaviorSubject<SimpleModel | undefined>(undefined);

  readonly nameControl = new FormControl();

  constructor(protected simpleVM: SimpleViewModel) { }

  ngOnInit(): void {
    this.simpleVM.init().subscribe(m => this.model$.next(m));
    this.model$.subscribe(m => {
      this.nameControl.patchValue(m?.name);
    })
  }

  postback(): void {
    this.simpleVM.postback({ ... this.model$.value, name: this.nameControl.value } as SimpleModel).subscribe(m => {
      this.model$.next(m);
    });
  }

}
