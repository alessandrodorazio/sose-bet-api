package it.univaq.aggm;
import javax.jws.WebService;
import javax.ws.rs.*;



import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Path("bets")
@Produces("text/xml")
@WebService(endpointInterface = "it.univaq.aggm.BetRepositoryInterface")
public class BetRepository implements BetRepositoryInterface {
	@GET
    @Path("calculate")
    public Bet calculateBet(@QueryParam("localTeam") int localTeamId, @QueryParam("visitorTeam") int visitorTeamId)  {
		Bet b = new Bet();
		b.setLocalTeamId(localTeamId);
		b.setVisitorTeamId(visitorTeamId);
		b.calculateQuote();
		return b;
    }
}
