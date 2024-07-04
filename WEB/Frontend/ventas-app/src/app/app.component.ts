import { Component, OnInit} from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';
import { initFlowbite } from 'flowbite';
import { ModalComponent } from "./modal/modal.component";
import { SwitchService } from './service/switch.service';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  imports: [RouterOutlet, RouterLink, ModalComponent]
})
export class AppComponent implements OnInit {

  title = 'ventas-app';
  modalSwitch: boolean = false;
  constructor(private modalSS:SwitchService){

  }
  ngOnInit(): void {
    initFlowbite();
    this.modalSS.$modal.subscribe((valor)=>(this.modalSwitch = valor))
  }
  openModal() {
    this.modalSwitch = true;
  }
}
