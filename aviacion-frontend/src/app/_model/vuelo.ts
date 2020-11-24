import { Horario } from './horario';
import { Operador } from './operador';
export class Vuelo {
    idVuelo : number;
    numero : string;
    operador : Operador;
    horarioSalida : Horario;
    horarioEntrada : Horario;
    fechaIngreso : string;
}