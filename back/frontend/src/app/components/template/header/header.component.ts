import { Component } from '@angular/core';
import { HomeComponent } from "../../../views/home/home.component";
import { RouterOutlet } from '@angular/router';




@Component({
    selector: 'app-header',
    standalone: true,
    templateUrl: './header.component.html',
    styleUrl: './header.component.css',
    imports: [HomeComponent, RouterOutlet]
})
export class HeaderComponent {

}
