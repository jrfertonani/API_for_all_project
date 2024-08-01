import { Component, OnInit } from '@angular/core';
import { Product } from '../product.model';
import { ProductService } from '../product.service';
import { CurrencyPipe, NgForOf,} from '@angular/common';


@Component({
  selector: 'app-product-read',
  standalone: true,
  imports: [NgForOf, CurrencyPipe],
  templateUrl: './product-read.component.html',
  styleUrl: './product-read.component.css',
})
export class ProductReadComponent implements OnInit {

  products: Product[] = [];

  //TABELA  --------------

  //TABELA  Pageable -----
  sliceProducts(currentPage: number, itemsPerPage: number): Product[] {
    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    return this.products.slice(startIndex, endIndex);
  }

  currentPage = 1;
  itemsPerPage = 10;
  totalPages = Math.ceil(this.products.length / this.itemsPerPage);

  //TABELA  --------------


  constructor(private productService: ProductService, ) {
  }

  ngOnInit(): void {
    this.productService.read().subscribe(products => {
      this.products = products;
      console.log('OK');
    });
  }



}
