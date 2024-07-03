import { Component, OnInit } from '@angular/core';
import { initFlowbite } from 'flowbite';

@Component({
  selector: 'app-accesorios',
  standalone: true,
  imports: [],
  templateUrl: './accesorios.component.html',
  styleUrl: './accesorios.component.css'
})
export default class AccesoriosComponent implements OnInit{
  ngOnInit(): void {
    initFlowbite()
  }
}
