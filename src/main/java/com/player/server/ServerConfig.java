package com.player.server;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.player.framework.util.XmlWrapper;


@Root(name = "server")
public class ServerConfig {

	private static volatile ServerConfig serverConfig;
	private static Logger logger = LoggerFactory.getLogger(ServerConfig.class);

	public static ServerConfig getInstance() {
		if (serverConfig != null) {
			return serverConfig;
		}
		synchronized (ServerConfig.class) {
			if (serverConfig == null) {
				try {
					serverConfig = XmlWrapper.load(ServerPath.SERVER_PATH, ServerConfig.class);
				} catch (Exception e) {
					logger.error("", e);
				}
			}
		}
		return serverConfig;
	}

	/** 连接服务器ip */
	@Element(required = true)
	private String connectServerIp;

	/** 连接服务器端口 */
	@Element(required = true)
	private int connectServerPort;

	public String getConnectServerIp() {
		return connectServerIp;
	}

	public int getConnectServerPort() {
		return connectServerPort;
	}

	/** 服务器端口 */
	@Element(required = true)
	private int serverPort;

	/** redis server url {http:port} */
	@Element(required = true)
	private String redisUrl;


	public int getServerPort() {
		return this.serverPort;
	}


}
