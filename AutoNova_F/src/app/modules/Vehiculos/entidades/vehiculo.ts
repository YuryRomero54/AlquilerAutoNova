export class Vehiculo {
    idVehiculo:number;
    tipo: string;
    placa: String;
    color: String;
    valorDiario:number;
    imagen: String;
    estado: String;

constructor(idVehiculo: number,tipo:string,placa:String,color:String,valorDiario:number,
    imagen:String,estado:String
) {
    this.idVehiculo = idVehiculo;
    this.color=color;
    this.estado=estado;
    this.imagen=imagen;
    this.placa=placa;
    this.tipo=tipo;
    this.valorDiario=valorDiario
    
  }
}
