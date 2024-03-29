/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Administrador;
import edu.eci.pdsw.samples.entities.Asistente;
import edu.eci.pdsw.samples.entities.Curso;
import edu.eci.pdsw.samples.persistence.TemaDAO;
import edu.eci.pdsw.samples.persistence.CursoDAO;
import edu.eci.pdsw.samples.persistence.GrupoDAO;
import edu.eci.pdsw.samples.persistence.FranjaDAO;
import edu.eci.pdsw.samples.persistence.MonitorDAO;
import edu.eci.pdsw.samples.persistence.ProfesorDAO;
import edu.eci.pdsw.samples.persistence.SemestreDAO;
import edu.eci.pdsw.samples.persistence.AsistenteDAO;
import edu.eci.pdsw.samples.persistence.MonitoriaDAO;
import edu.eci.pdsw.samples.persistence.EstudianteDAO;
import edu.eci.pdsw.samples.persistence.AdministradorDAO;
import edu.eci.pdsw.samples.persistence.PersistenceException;

import edu.eci.pdsw.samples.entities.Monitoria;
import edu.eci.pdsw.samples.entities.Profesor;
import edu.eci.pdsw.samples.entities.Semestre;
import edu.eci.pdsw.samples.services.ServiciosMonitoria;
import edu.eci.pdsw.samples.services.ExcepcionServiciosMonitoria;
import java.util.Date;
import java.util.List;

/**
 *
 * @author camil
 */
public class ServiciosMonitoriaImpl implements ServiciosMonitoria {

    @Inject
    private AdministradorDAO daoAdministrador;

    @Inject
    private AsistenteDAO daoAsistente;

//    @Inject
//    private CursoDAO daoCurso;
//
//    @Inject
//    private EstudianteDAO daoEstudiante;
//
//    @Inject
//    private FranjaDAO daoFranja;
//
//    @Inject
//    private GrupoDAO daoGrupo;
//
//    @Inject
//    private MonitorDAO daoMonitor;
//
//    @Inject
//    private MonitoriaDAO daoMonitoria;
    @Inject
    private ProfesorDAO daoProfesor;

    @Inject
    private SemestreDAO daoSemestre;
//
//    @Inject
//    private TemaDAO daoTema;

    @Override
    public void registrarAdministrador(Administrador admin) throws ExcepcionServiciosMonitoria {
        try {
            daoAdministrador.save(admin);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosMonitoria("Error al registrar al administrador con Codigo: " + admin.getCodigo(), e);
        }
    }

    @Override
    public Administrador consultarAdministrador(Integer codigo) throws ExcepcionServiciosMonitoria {
        try {
            return daoAdministrador.load(codigo);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosMonitoria("Error al consultar al administrador con Codigo: " + codigo, e);
        }
    }

    @Override
    public List<Administrador> consultarAdministradores() throws ExcepcionServiciosMonitoria {
        try {
            return daoAdministrador.loadAll();
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosMonitoria("Error al consultar todos los administradores registrados. ", e);
        }
    }

    @Override
    public void registrarSemestre(Semestre sem) throws ExcepcionServiciosMonitoria {
        try {
            daoSemestre.save(sem);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosMonitoria("Error al registrar el semestre: " + sem.getYears() + "-" + sem.getPeriodoAcademico(), e);
        }
    }

    @Override
    public Semestre consultarSemestre(Integer year, String periodo) throws ExcepcionServiciosMonitoria {
        try {
            return daoSemestre.load(year, periodo);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosMonitoria("Error al consultar el semestre: " + year + "-" + periodo, e);
        }
    }

    @Override
    public List<Semestre> consultarSemestres() throws ExcepcionServiciosMonitoria {
        try {
            return daoSemestre.loadAll();
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosMonitoria("Error al consultar todos los semestres registrados. ", e);
        }
    }

    @Override
    public void registrarProfesor(Profesor pro) throws ExcepcionServiciosMonitoria {
        try {
            daoProfesor.save(pro);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosMonitoria("Error al registrar al profesor con Codigo: " + pro.getCodigo(), e);
        }
    }

    @Override
    public Profesor consultarProfesor(Integer codigo) throws ExcepcionServiciosMonitoria {
        try {
            return daoProfesor.load(codigo);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosMonitoria("Error al consultar al profesor con Codigo: " + codigo, e);
        }
    }

    @Override
    public List<Profesor> consultarProfesores() throws ExcepcionServiciosMonitoria {
        try {
            return daoProfesor.loadAll();
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosMonitoria("Error al consultar todos los profesores registrados. ", e);
        }
    }

    @Override
    public void registrarMonitoria(int id, Date fecha, Date horaInicio, Date horaFin, String direccionIp, String observaciones, int codigoMonitor) throws ExcepcionServiciosMonitoria {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Monitoria consultarMonitoria() throws ExcepcionServiciosMonitoria {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Monitoria> consultarMonitorias() throws ExcepcionServiciosMonitoria {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Asistente> consultarAsistentesXCurso(Curso curso) throws ExcepcionServiciosMonitoria {
        try {
            return daoAsistente.loadAsistenteXCurso(curso);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosMonitoria("Error al consultar los asistentes en las monitorias del grupo: " + curso.getNemonico(), e);
        }
    }

}
