import { Component, OnInit } from '@angular/core';
import { initFlowbite } from 'flowbite';

@Component({
  selector: 'app-laptop',
  standalone: true,
  imports: [],
  templateUrl: './laptop.component.html',
  styleUrl: './laptop.component.css'
})
export default class LaptopComponent implements OnInit{
  ngOnInit(): void {
    initFlowbite()
  }
}
