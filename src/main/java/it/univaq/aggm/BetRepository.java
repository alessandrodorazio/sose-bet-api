package it.univaq.aggm;
import javax.ws.rs.*;



import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Path("bets")
@Produces("text/xml")
public class BetRepository {
	@GET
    @Path("match")
    public Bet calculateBet(@QueryParam("localTeam") int localTeamId, @QueryParam("visitorTeam") int visitorTeamId)  {
		Bet b = new Bet();
		b.setLocalTeamId(localTeamId);
		b.setVisitorTeamId(visitorTeamId);
		b.calculateQuote();
		return b;
    }
}
