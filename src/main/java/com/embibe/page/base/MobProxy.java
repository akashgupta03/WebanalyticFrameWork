package com.embibe.page.base;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class MobProxy {
    public  static BrowserMobProxyServer proxy;

    public MobProxy() {
        createProxyServer();
    }

    private void createProxyServer() {
        proxy = new BrowserMobProxyServer();
        proxy.setTrustAllServers(true); // above line is needed for application with invalid certificates
        proxy.start(0);
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_HEADERS,CaptureType.REQUEST_COOKIES);
    }


    public BrowserMobProxy getProxyServer() {
        return proxy;
    }

    public Proxy getSeleniumProxy() {
        return getSeleniumProxy(proxy);
    }

    public Proxy getSeleniumProxy(BrowserMobProxy proxyServer) {
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        try {
            String hostIp = Inet4Address.getLocalHost().getHostAddress();
            seleniumProxy.setHttpProxy(hostIp+":" + proxyServer.getPort());
            seleniumProxy.setSslProxy(hostIp+":" + proxyServer.getPort());
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
            //Assert.fail("invalid Host Address");
        }
        return seleniumProxy;
    }



    public DesiredCapabilities setUpDesiredCapbility() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Proxy seleniumProxy = getSeleniumProxy();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        proxy.newHar("embibe.com");
        return capabilities;

    }

}
