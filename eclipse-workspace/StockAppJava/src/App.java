import java.util.*;

import org.patriques.*;
import org.patriques.input.technicalindicators.*;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.digitalcurrencies.*;
import org.patriques.output.timeseries.data.StockData;

public class App {
	public static void main(String[] args) {
	    String apiKey = "MPU9SWSSM6N4PLEU";
	    int timeout = 3000;
	    AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
	    TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
	    
	    try {
	      IntraDay response = stockTimeSeries.intraDay("MSFT", Interval.ONE_MIN, OutputSize.COMPACT);
	      Map<String, String> metaData = response.getMetaData();
	      System.out.println("Information: " + metaData.get("1. Information"));
	      System.out.println("Stock: " + metaData.get("2. Symbol"));
	      
	      List<StockData> stockData = response.getStockData();
	      stockData.forEach(stock -> {
	        System.out.println("date:   " + stock.getDateTime());
	        System.out.println("open:   " + stock.getOpen());
	        System.out.println("high:   " + stock.getHigh());
	        System.out.println("low:    " + stock.getLow());
	        System.out.println("close:  " + stock.getClose());
	        System.out.println("volume: " + stock.getVolume());
	      });
	    } catch (AlphaVantageException e) {
	      System.out.println("something went wrong");
	    }
	  }
}
