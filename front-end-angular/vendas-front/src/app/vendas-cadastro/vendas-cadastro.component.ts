import { MessageService } from "primeng/components/common/messageservice";
import { VendasServiceService } from "./../vendas/vendas-service.service";
import { Component, OnInit, Output, EventEmitter } from "@angular/core";
import { FormGroup } from "@angular/forms";

@Component({
  selector: "app-vendas-cadastro",
  templateUrl: "./vendas-cadastro.component.html",
  styleUrls: ["./vendas-cadastro.component.css"]
})
export class VendasCadastroComponent implements OnInit {
  item: any = {};
  venda: any = {};
  clientes: Array<any>;
  produtos: Array<any>;

  @Output()
  vendaSalva = new EventEmitter();

  constructor(
    private service: VendasServiceService,
    private messageService: MessageService
  ) {}

  ngOnInit() {
    this.novaVenda();

    this.service.listarClientes().subscribe(res => {
      this.clientes = res;
    });

    this.service.listarProdutos().subscribe(res => {
      this.produtos = res;
    });
  }
  incluirItem() {
    this.item.total = this.item.produto.valor * this.item.quantidade;
    this.venda.itens.push(this.item);
    this.item = {};
    this.calcularTotal();
  }

  calcularTotal() {
    const totalItens = this.venda.itens
      .map(i => i.produto.valor * i.quantidade)
      .reduce((total, v) => total + v, 0);

    this.venda.total = totalItens + this.venda.frete;
  }

  novaVenda() {
    this.venda = { itens: [], frete: 0, total: 0 };
    this.item = {};
  }

  adicionar(frm: FormGroup) {
    this.service.adicionar(this.venda).subscribe(res => {
      frm.reset();

      this.novaVenda();

      this.messageService.add({
        severity: "sucess",
        detail: "Venda adicionada com sucesso!"
      });

      this.vendaSalva.emit(res);
    });
  }
}
