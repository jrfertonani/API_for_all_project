import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductReadComponent } from "../../components/products/product-read/product-read.component";

@Component({
    selector: 'app-product-crud',
    standalone: true,
    templateUrl: './product-crud.component.html',
    styleUrl: './product-crud.component.css',
    imports: [ProductReadComponent]
})
export class ProductCrudComponent implements OnInit {

  constructor(private router: Router) {}

  ngOnInit(): void {}

  navigateToProductCreate(): void {
    this.router.navigate(['/products/create'])
  }
}
