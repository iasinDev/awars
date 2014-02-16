/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javiermoreno.awsdemos.awarsconsole;

import com.javiermoreno.awsdemos.awarsconsole.domain.ConflictStats;
import java.util.Map;

/**
 *
 * @author ciberado
 */
public interface StatsService {

    void updateConflictStats(String warId, String opponentWarId, String appName, 
                             String instanceId, String instanceType, long start, 
                             long end, int requestCount, double avgResponseTimeMs);

    Map<String, ConflictStats> getConflictStats();

   
}
