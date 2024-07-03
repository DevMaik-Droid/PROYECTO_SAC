import { Component, OnInit } from '@angular/core';
import { initFlowbite } from 'flowbite';

@Component({
  selector: 'app-contactos',
  standalone: true,
  imports: [],
  templateUrl: './contactos.component.html',
  styleUrl: './contactos.component.css'
})
export default class ContactosComponent implements OnInit{
ngOnInit(): void {
  initFlowbite()
}
}
