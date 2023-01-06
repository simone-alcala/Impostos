package entities;

public class PessoaFisica extends Pessoa {

  private Double saude; 

  
  public PessoaFisica() {
    super();
  }

  public PessoaFisica(String nome, Double rendaAnual, Double saude) {
    super(nome, rendaAnual);
    this.saude = saude;
  }
  
  public Double getSaude() {
    return saude;
  }
  
  public void setSaude(Double saude) {
    this.saude = saude;
  }
  
  @Override
  public Double imposto() {
    double rendaAnual =  getRendaAnual();
    double imposto = 0.0;

    if (rendaAnual < 20000) {
      imposto = rendaAnual * 0.15;
    } else {
      imposto = rendaAnual * 0.25;
    }

    if (saude > 0) {
      imposto -= saude * 0.5;
    }

    return imposto;
  }

}
