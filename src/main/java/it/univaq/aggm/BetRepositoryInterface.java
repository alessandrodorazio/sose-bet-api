package it.univaq.aggm;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface BetRepositoryInterface {
	@WebMethod
	public Bet calculateBet(int localTeamId, int visitorTeamId);
}
