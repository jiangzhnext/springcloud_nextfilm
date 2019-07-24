package com.next.jiangzh.springboot.nextfilmcinema.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyRule extends AbstractLoadBalancerRule {
    public MyRule() {
    }

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        // 无论什么情况都返回null值

        // 灰度发布 -> 10~20%的流量到一个新的服务上，剩余的打到旧的服务上

        return null;
//        if (lb == null) {
//            return null;
//        } else {
//            Server server = null;
//
//            while (server == null) {
//                if (Thread.interrupted()) {
//                    return null;
//                }
//
//                List<Server> upList = lb.getReachableServers();
//                List<Server> allList = lb.getAllServers();
//                int serverCount = allList.size();
//                if (serverCount == 0) {
//                    return null;
//                }
//
//                // 想办法找到一个可用的服务下标
//                int index = this.chooseRandomInt(serverCount);
//
//                server = (Server) upList.get(index);
//
//                if (server == null) {
//                    Thread.yield();
//                } else {
//                    if (server.isAlive()) {
//                        return server;
//                    }
//
//                    server = null;
//                    Thread.yield();
//                }
//            }
//
//            return server;
//        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}