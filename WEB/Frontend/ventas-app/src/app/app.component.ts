import { Component, OnInit } from '@angular/core';
import { RouterOutlet,RouterLink } from '@angular/router';
import { initFlowbite } from 'flowbite';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'ventas-app';
  ngOnInit(): void {
    initFlowbite()
  }
}
