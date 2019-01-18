package com.example.user.shopassistant.network;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;

/**
 * Created by User on 02.12.2016.
 */

public class CRestClient {
    public static String BASE_URL = "http://shopassistant.ru/api/";
    public static String BASE_URL_WITHOUT_API = "http://shopassistant.ru/";

    public static AsyncHttpClient client = new AsyncHttpClient();

    /*public static void setCookieStore(Context context) {
        PersistentCookieStore cookieStore = new PersistentCookieStore(context);
        client.setCookieStore(cookieStore);
    }

    public static void getCookies(Context context) {
        PersistentCookieStore myCookieStore = new PersistentCookieStore(context);
        BasicClientCookie clientCookie = new BasicClientCookie("contacts_cookie", "alias_cookie");
        clientCookie.setVersion(1);
        clientCookie.setDomain("shopassistant.ru");
        clientCookie.setPath("/");
        myCookieStore.addCookie(clientCookie);
    }*/

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(Context context, String url, HttpEntity entity, String contentType, AsyncHttpResponseHandler responseHandler) {
        client.post(context, getAbsoluteUrl(url), entity, contentType, responseHandler);
    }

    public static void post(Context context, String url, Header[] headers, RequestParams params, String contentType, AsyncHttpResponseHandler responseHandler) {
        client.post(context, getAbsoluteUrl(url), headers, params, contentType, responseHandler);
    }

    public static void put(Context context, String url, RequestParams params, AsyncHttpResponseHandler handler) {
        client.put(getAbsoluteUrl(url), params, handler);
    }

    public static void delete(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.delete(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
