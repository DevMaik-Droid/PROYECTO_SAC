import { Component, OnInit } from '@angular/core';
import { initFlowbite } from 'flowbite';

@Component({
  selector: 'app-componentes',
  standalone: true,
  imports: [],
  templateUrl: './componentes.component.html',
  styleUrl: './componentes.component.css'
})
export default class ComponentesComponent implements OnInit {
  ngOnInit(): void {
    initFlowbite()
}
}
