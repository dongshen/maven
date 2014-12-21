package com.sdong.maven.weather;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.sdong.maven.weather.Weather;
import com.sdong.maven.weather.WeatherFormatter;
import com.sdong.maven.weather.YahooParser;

public class WeatherFormatterTest {

	@Test
	public void testFormat() throws Exception {
		InputStream nyData =
				getClass().getClassLoader().getResourceAsStream("ny-weather.xml");
		Weather weather = new YahooParser().parse(nyData);
		String formattedResult = new WeatherFormatter().format(weather);
		InputStream expected =
				getClass().getClassLoader().getResourceAsStream("format-expected.dat");
		assertEquals(IOUtils.toString(expected), formattedResult);
	}
}
