# Spring Transaction Management
using Declarative Approach
<hr>
<b>Using Declarative Spring AOP and Spring Tx</b><br><br>

    <tx:advice id="txAdvice" transaction-manager="transactionManager">
    		<tx:attributes>
    			<tx:method name="fundTransfer*" 
    					propagation="REQUIRED" rollback-for="java.lang.Exception" read-only="false"/>
    		</tx:attributes>
    	</tx:advice>
    	<aop:config>
    		<aop:pointcut expression="execution(* com.swadesibank.transaction.service.AccountService.fundTransferWithException(..))" id="updateOperation"/>
    		<aop:advisor advice-ref="txAdvice" pointcut-ref="updateOperation"/>
    	</aop:config>
