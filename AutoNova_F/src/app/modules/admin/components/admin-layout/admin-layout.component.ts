import { Component } from '@angular/core';
import { NgFor } from '@angular/common';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzTagModule } from 'ng-zorro-antd/tag';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { CommonModule } from '@angular/common';
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { RouterOutlet } from '@angular/router';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-admin-layout',
  standalone: true,
  imports: [NgFor,NzTagModule,NzCardModule,NzIconModule,NzLayoutModule,NzTableModule,CommonModule,RouterLink
    , RouterOutlet
  ],
  templateUrl: './admin-layout.component.html',
  styleUrl: './admin-layout.component.css'
})
export class AdminLayoutComponent {
  isCollapsed = false;
}
