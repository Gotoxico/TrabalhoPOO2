/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Restaurante;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Data {
    private LocalDate data;
    private ArrayList<Horario> horarios;

    public Data() {
    }

    public Data(LocalDate data, LocalTime horarioInicio, LocalTime horarioFinal) {
        this.data = data;
        this.horarios = new ArrayList<>();
        int horas = horarioInicio.getHour();
        int minutos = horarioInicio.getMinute();
        int totalMinutos = (60*horas)+minutos;
        
        LocalTime diferenca = horarioFinal.minusMinutes(totalMinutos);
        
        int horasDiferenca = diferenca.getHour();
        int minutosDiferenca = diferenca.getMinute();
        int totalMinutosDiferenca = (60*horasDiferenca)+minutosDiferenca;
        
        int contadorMinutos = 0;
        
        while(contadorMinutos != totalMinutosDiferenca+15){
            Horario h = new Horario(horarioInicio.plusMinutes(contadorMinutos), false);
            horarios.add(h);
            contadorMinutos = contadorMinutos + 15;
        }
        
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }
    
    public void inserirReserva(LocalTime horario){
        for(Horario hora : horarios){
            if(hora.getHorario().equals(horario) && hora.isDisponibilidade() == false){
                int i = 0;
                while(i != 135){
                    int proximoIndex = horarios.indexOf(hora) + i;
                    if(proximoIndex < horarios.size()){
                        horarios.get(proximoIndex).setDisponibilidade(true);
                    }
                    i = i + 15;
                }
            }
        }
    }
    
}
