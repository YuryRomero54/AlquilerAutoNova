export interface GestionReserva {
  id?: number; // opcional si lo genera el backend
  idReserva: number;
  fechaGestion: string; // formato: 'yyyy-MM-dd'
  tipoAccion: string;
  observaciones: string;
}
