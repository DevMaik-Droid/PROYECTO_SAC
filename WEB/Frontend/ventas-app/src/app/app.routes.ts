import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadComponent: () => import('./home/home.component')
    },
    {
        path: 'computadoras',
        loadComponent: () => import('./computadoras/computadoras.component')
    },
    {
        path: 'laptops',
        loadComponent: () => import('./laptop/laptop.component')
    },
    {
        path: 'componentes',
        loadComponent: () => import('./componentes/componentes.component')
    },
    {
        path: 'accesorios',
        loadComponent: () => import('./accesorios/accesorios.component')
    },

    {
        path: 'contactos',
        loadComponent: () => import('./contactos/contactos.component')
    },

];
