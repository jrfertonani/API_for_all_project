import { Component, OnInit } from '@angular/core';
import { Product } from '../product.model';
import { ProductService } from '../product.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-product-delete',
  standalone: true,
  imports: [],
  templateUrl: './product-delete.component.html',
  styleUrl: './product-delete.component.css'
})
export class ProductDeleteComponent implements OnInit{

 product!: Product;

  constructor(
    private productService: ProductService,
    private router: Router,
    private route: ActivatedRoute
  ){}


  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
       if (id) {
        this.productService.readById(id).subscribe(product => {
        this.product = product;
        });
      }
    });
  }




  deleteProduct(): void {
    if (this.product && this.product.id) { // Check if product and id exist
      this.productService.delete(this.product.id).subscribe(() => {
        this.productService.showMessage("Produto excluido com sucesso!");
        this.router.navigate(['/products']);
      });
    } else {
      console.error("Product data or ID is missing."); // Handle missing data
    }
  }

  cancel(): void{
    this.router.navigate(['/products'])
  }
}
