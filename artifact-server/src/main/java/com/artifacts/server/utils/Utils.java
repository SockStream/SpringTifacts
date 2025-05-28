package com.artifacts.server.utils;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import org.openapitools.ApiException;
import org.openapitools.client.MapsApi;
import org.openapitools.client.MyAccountApi;
import org.openapitools.client.model.CharacterSchema;
import org.openapitools.client.model.DataPageMapSchema;
import org.openapitools.client.model.DataPageSimpleItemSchema;
import org.openapitools.client.model.InventorySlot;
import org.openapitools.client.model.ItemResponseSchema;
import org.openapitools.client.model.MapContentType;
import org.openapitools.client.model.MapSchema;
import org.openapitools.client.model.SimpleItemSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.artifacts.server.service.GameDataStore;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class Utils {
	public static GameDataStore gameDataStore;

    @Autowired
    public Utils(GameDataStore gameDataStore) {
    	Utils.gameDataStore = gameDataStore;
    }
    
	
	public static MapSchema PlusProcheDe(CharacterSchema characterSchema, String mapContentCode, MapContentType mapContentType) throws ApiException
	{
		MapsApi mapsApi = gameDataStore.getMapsApi();
		
    	DataPageMapSchema dataPageMapSchema = mapsApi.getAllMapsMapsGet(mapContentType,mapContentCode,null,null);
    	int x = characterSchema.getX();
    	int y = characterSchema.getY();
    	Comparator<MapSchema> mapComparator = Comparator.comparingInt(
    		    m -> Math.abs(m.getX() - x) + Math.abs(m.getY() - y)
    		);
    	MapSchema mapSchema = dataPageMapSchema.getData().stream().sorted(mapComparator).findFirst().get();
    	return mapSchema;
	}
	
	public static int CompterObjetsSac(CharacterSchema characterSchema)
	{
		int tailleSac = 0;
		for(InventorySlot inv : characterSchema.getInventory())
		{
			tailleSac += inv.getQuantity();
		}
		return tailleSac;
	}


	public static int NombreItemsPourCraftUn(String itemCode) {
		int nb = 0;
		
		try {
			ItemResponseSchema itemResponseSchema = gameDataStore.getItemsApi().getItemItemsCodeGet(itemCode);
			for(SimpleItemSchema simpleItemSchema : itemResponseSchema.getData().getCraft().getItems())
			{
				nb += simpleItemSchema.getQuantity();
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		
		return nb;
	}


	public static int QuantiteEnBanque(String code) throws ApiException {
		int qte = 0;
		
		MyAccountApi myAccountApi = gameDataStore.getMyAccountApi();
		DataPageSimpleItemSchema dataPageSimpleItemSchema = myAccountApi.getBankItemsMyBankItemsGet(code, null, null);
		List<SimpleItemSchema> simpleItemSchemaList  = dataPageSimpleItemSchema.getData();
		if(simpleItemSchemaList.isEmpty())
		{
			return 0;
		}
		qte = simpleItemSchemaList.getFirst().getQuantity();
		return qte;
	}
	
	public static int QuantiteEnInventaire(String characterId, String itemCode) {
		int qte = 0;
		for( InventorySlot inventaire : gameDataStore.getCharacter(characterId).getInventory())
		{
			if( inventaire.getCode().equals(itemCode))
			{
				qte = inventaire.getQuantity();
			}
		}
		return qte;
	}
	
	public static void SendPushBulletNotification(String title, String body) throws IOException {
		
		
		    String accessToken = "o.1dtRxKC84DI3UZ0ol1cLMlf8rwILJRaQ";

		    OkHttpClient client = new OkHttpClient();
		    RequestBody requestBody = new FormBody.Builder()
		        .add("type", "note")
		        .add("title", title)
		        .add("body", body)
		        .build();

		    Request request = new Request.Builder()
		        .url("https://api.pushbullet.com/v2/pushes")
		        .header("Access-Token", accessToken)
		        .post(requestBody)
		        .build();

		    Response response = client.newCall(request).execute();
		    System.out.println("Notification envoyée : " + response.code());
	}
}
