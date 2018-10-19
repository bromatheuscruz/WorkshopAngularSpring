import { VendasServiceService } from "./../vendas/vendas-service.service";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-vendas-listagem",
  templateUrl: "./vendas-listagem.component.html",
  styleUrls: ["./vendas-listagem.component.css"]
})
export class VendasListagemComponent implements OnInit {
  vendas: Array<any>;

  constructor(private vendaService: VendasServiceService) {}

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.vendaService.listar().subscribe(res => {
      this.vendas = res;
    });
  }
}
