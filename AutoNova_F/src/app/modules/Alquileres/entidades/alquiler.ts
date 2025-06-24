
import { Usuario } from '../../Usuarios/entidades/usuario';
import { Vehiculo } from '../../Vehiculos/entidades/vehiculo';

export interface Alquiler {
  idAlquiler: number;
  usuario: Usuario;
  vehiculo: Vehiculo;
  fecha_inicio: Date;
  fecha_entrega: Date;
  estado: string;
  valor: number;
}

