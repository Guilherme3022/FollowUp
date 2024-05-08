package br.com.megacomex.Domain.entities;

import java.util.Date;

public class FollowUP {
    private int id;
    private String refMega;
    private String funcionariosResponsaveis;
    private String nomeTrading;
    private String notify;
    private String refCliente;
    private String fornecedor;
    private String navio;
    private Date chegada;
    private String hbl;
    private String armador;
    private String agente;
    private String cntr;
    private String recinto;
    private String docsOriginal;
    private String fio_QuantidadeFio_PrecoFio;

    private String pagtoAdv_AVista;
    private Date descarga;
    private Date dataRegistro;
    private String n_DI;
    private String canal;
    private Date desenbaraco;
    private int live;
    private String QRegistrou;
    private Date dataRegistrou;
    private char indice;


    public FollowUP(int id, String refMega, String funcionarioResponsavel,String trading, String notify, String refCliente,
                    String fornecedor, String navio, Date chegada, String hbl, String armador, String agente, String cntr,
                    String recinto, String docsOriginal, String fio_QuantidadeFio_PrecoFio, String pagtoAdv_AVista, Date descarga,
                    Date dataRegistro, String n_DI, String canal, Date desenbaraco, String qregistrou, Date dataRegistrou) {
        this.id = id;
        this.refMega = refMega;
        this.funcionariosResponsaveis = funcionarioResponsavel;
        this.nomeTrading = trading;
        this.notify = notify;
        this.refCliente = refCliente;
        this.fornecedor = fornecedor;
        this.navio = navio;
        this.chegada = chegada;
        this.hbl = hbl;
        this.armador = armador;
        this.agente = agente;
        this.cntr = cntr;
        this.recinto = recinto;
        this.docsOriginal = docsOriginal;
        this.fio_QuantidadeFio_PrecoFio = fio_QuantidadeFio_PrecoFio;
        this.pagtoAdv_AVista = pagtoAdv_AVista;
        this.descarga = descarga;
        this.dataRegistro = dataRegistro;
        this.n_DI = n_DI;
        this.canal = canal;
        this.desenbaraco = desenbaraco;
        this.QRegistrou = qregistrou;
        this.dataRegistrou = dataRegistrou;

    }

    public FollowUP(String refMega, String funcionariosResponsaveis, String nomeTrading, String notify, String refCliente, String fornecedor, String navio, Date chegada, String hbl, String armador, String agente, String cntr, String recinto, String docsOriginal, String fio_QuantidadeFio_PrecoFio, String pagtoAdv_AVista, Date descarga, Date dataRegistro, String n_DI, String canal, Date desenbaraco) {
        this.refMega = refMega;
        this.funcionariosResponsaveis = funcionariosResponsaveis;
        this.nomeTrading = nomeTrading;
        this.notify = notify;
        this.refCliente = refCliente;
        this.fornecedor = fornecedor;
        this.navio = navio;
        this.chegada = chegada;
        this.hbl = hbl;
        this.armador = armador;
        this.agente = agente;
        this.cntr = cntr;
        this.recinto = recinto;
        this.docsOriginal = docsOriginal;
        this.fio_QuantidadeFio_PrecoFio = fio_QuantidadeFio_PrecoFio;
        this.pagtoAdv_AVista = pagtoAdv_AVista;
        this.descarga = descarga;
        this.dataRegistro = dataRegistro;
        this.n_DI = n_DI;
        this.canal = canal;
        this.desenbaraco = desenbaraco;
    }

    public FollowUP() {
    }

    public String getFuncionariosResponsaveis() {
        return funcionariosResponsaveis;
    }

    public void setFuncionariosResponsaveis(String funcionariosResponsaveis) {
        this.funcionariosResponsaveis = funcionariosResponsaveis;
    }

    public String getNomeTrading() {
        return nomeTrading;
    }

    public void setNomeTrading(String nomeTrading) {
        this.nomeTrading = nomeTrading;
    }

    public int getId() {
        return id;
    }

    public int getLive() {
        return live;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefMega() {
        return refMega;
    }

    public void setRefMega(String refMega) {
        this.refMega = refMega;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public String getRefCliente() {
        return refCliente;
    }

    public void setRefCliente(String refCliente) {
        this.refCliente = refCliente;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNavio() {
        return navio;
    }

    public void setNavio(String navio) {
        this.navio = navio;
    }

    public Date getChegada() {
        return chegada;
    }

    public void setChegada(Date chegada) {
        this.chegada = chegada;
    }

    public String getHbl() {
        return hbl;
    }

    public void setHbl(String hbl) {
        this.hbl = hbl;
    }

    public String getArmador() {
        return armador;
    }

    public void setArmador(String armador) {
        this.armador = armador;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getCntr() {
        return cntr;
    }

    public void setCntr(String cntr) {
        this.cntr = cntr;
    }

    public String getRecinto() {
        return recinto;
    }

    public void setRecinto(String recinto) {
        this.recinto = recinto;
    }

    public String getDocsOriginal() {
        return docsOriginal;
    }

    public void setDocsOriginal(String docsOriginal) {
        this.docsOriginal = docsOriginal;
    }

    public String getFio_QuantidadeFio_PrecoFio() {
        return fio_QuantidadeFio_PrecoFio;
    }

    public void setFio_QuantidadeFio_PrecoFio(String fio_QuantidadeFio_PrecoFio) {
        this.fio_QuantidadeFio_PrecoFio = fio_QuantidadeFio_PrecoFio;
    }

    public String getPagtoAdv_AVista() {
        return pagtoAdv_AVista;
    }

    public void setPagtoAdv_AVista(String pagtoAdv_AVista) {
        this.pagtoAdv_AVista = pagtoAdv_AVista;
    }

    public Date getDescarga() {
        return descarga;
    }

    public void setDescarga(Date descarga) {
        this.descarga = descarga;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getN_DI() {
        return n_DI;
    }

    public void setN_DI(String n_DI) {
        this.n_DI = n_DI;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public Date getDesenbaraco() {
        return desenbaraco;
    }

    public void setDesenbaraco(Date desenbaraco) {
        this.desenbaraco = desenbaraco;
    }

    public int isLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public String getQRegistrou() {
        return QRegistrou;
    }

    public void setQRegistrou(String QRegistrou) {
        this.QRegistrou = QRegistrou;
    }

    public Date getDataRegistrou() {
        return dataRegistrou;
    }

    public void setDataRegistrou(Date dataRegistrou) {
        this.dataRegistrou = dataRegistrou;
    }

    public char getIndice() {
        return indice;
    }

    public void setIndice(char indice) {
        this.indice = indice;
    }
}
