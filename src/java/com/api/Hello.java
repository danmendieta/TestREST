/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.api;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zerofkw
 */
@Path("/hello")
public class Hello {
    
    @Path("/hola")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String respuesta(){
        String resp = "Hola!!";
        List<String> lista = new ArrayList<String>();
        lista.add("Uno");
        lista.add("Dos");
        lista.add("Tres");
        return resp;
    }

    @Path("/conJson")
    @POST
    @Produces(MediaType.APPLICATION_JSON)//Que envia? JSON
    @Consumes(MediaType.APPLICATION_JSON)//Que Recibe? JSON o puede recibir texto plano MediaType.TEXT_PLAIN o Query por URL(inseguro)
    public JsonPrueba pruebaConJSONS(JsonPrueba jsonrecibido){
        return jsonrecibido;
    }


    @Path("/masDiez")
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})//De esta manera recibe JSON o XML
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public JsonPrueba RecibidoMasDiez(JsonPrueba jsonrecibido){
        JsonPrueba nuevoObjeto = new JsonPrueba();
        nuevoObjeto.setNombre(jsonrecibido.getNombre() +" | "+ 10);
        nuevoObjeto.setCantidad(jsonrecibido.getCantidad() + 10);
        nuevoObjeto.setFecha(jsonrecibido.getFecha()+" | " +10);
        nuevoObjeto.setId(jsonrecibido.getId() +10);
        nuevoObjeto.setPrecio(jsonrecibido.getPrecio() +10);
        return nuevoObjeto;
    }
}
