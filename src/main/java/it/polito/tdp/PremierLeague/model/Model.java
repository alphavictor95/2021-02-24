package it.polito.tdp.PremierLeague.model;

import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {

	PremierLeagueDAO dao = new PremierLeagueDAO();

	Graph<Integer, DefaultWeightedEdge> grafo;

	public List<Match> getMatches() {
		return dao.listAllMatches();

	}

	public String creaGrafo(Match selezionato) {
		this.grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		for (Arco a : dao.getPlayerDiMatch(selezionato)) {
			if (a.getEff1() > a.getEff2()) {
				Graphs.addEdgeWithVertices(this.grafo, a.getpID1(), a.getpID2(), a.getPeso());
			} else {
				Graphs.addEdgeWithVertices(this.grafo, a.getpID2(), a.getpID1(), a.getPeso());
			}

		}
		return String.format("Grafo creato con %d vertici e %d archi\n", this.grafo.vertexSet().size(),
				this.grafo.edgeSet().size());
	}

	public String getGiocatoreMigliore() {
		double maxEff = 0;
		String migliore="";

		for (int i : this.grafo.vertexSet()) {
			double pesoEntrante = 0.0;
            for (DefaultWeightedEdge e : this.grafo.incomingEdgesOf(i)) {
				pesoEntrante += this.grafo.getEdgeWeight(e);
			}
			double pesoUscente = 0.0;
			for(DefaultWeightedEdge e : this.grafo.outgoingEdgesOf(i)) {
				pesoUscente += this.grafo.getEdgeWeight(e);
			}
			double delta = pesoUscente-pesoEntrante;
			if(delta>maxEff) {
				maxEff = delta;
				migliore = "Migliore: "+i+" "+ dao.getIdPlayer(i) + " " + maxEff;
			}
		}
		return migliore;
	}

}
