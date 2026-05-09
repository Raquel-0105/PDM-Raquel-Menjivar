package com.example.parcial1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial1.ui.theme.Parcial1Theme

val BackgroundDark = Color(0xFF12121A)
val CardDark = Color(0xFF1E1E26)
val PrimaryPurple = Color(0xFF7F00FF)
val SecondaryPurple = Color(0xFFE100FF)
val TextGray = Color(0xFF9E9E9E)
val SuccessGreen = Color(0xFF00C853)

@Composable
fun GradientButton(
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { },
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(24.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(listOf(PrimaryPurple, SecondaryPurple)),
                    RoundedCornerShape(24.dp)
                )
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}


@Composable
fun StatCard(title: String, value: String, icon: ImageVector, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = CardDark),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Icon(icon, contentDescription = null, tint = TextGray, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, color = TextGray, fontSize = 12.sp)
            Text(text = value, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DashboardScreen() {
    Scaffold(
        containerColor = BackgroundDark,
        topBar = {
            Row(
                Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Dashboard", color = TextGray, fontSize = 14.sp)
                    Text("Overview", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
                Icon(Icons.Default.Notifications, contentDescription = null, tint = Color.White)
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).padding(horizontal = 16.dp)) {
            item {
                // Tarjeta de Balance Total
                Card(
                    modifier = Modifier.fillMaxWidth().height(180.dp),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize().background(
                        Brush.horizontalGradient(listOf(PrimaryPurple, SecondaryPurple))
                    ).padding(20.dp)) {
                        Column {
                            Text("Total Balance", color = Color.White.copy(alpha = 0.8f))
                            Text("$24,580.00", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.weight(1f))
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.2f))) {
                                    Text("Add Funds", color = Color.White)
                                }
                                Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.2f))) {
                                    Text("Withdraw", color = Color.White)
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                // Grid de Estadísticas
                Column {
                    Row(Modifier.fillMaxWidth()) {
                        StatCard("Revenue", "$12K", Icons.Default.CheckCircle, Modifier.weight(1f))
                        StatCard("Users", "1.2K", Icons.Default.Person, Modifier.weight(1f))
                    }
                    Row(Modifier.fillMaxWidth()) {
                        StatCard("Growth", "+18%", Icons.Default.CheckCircle, Modifier.weight(1f))
                        StatCard("Orders", "320", Icons.Default.CheckCircle, Modifier.weight(1f))
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                Text("Recent Activity", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
            }

            items(3) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("Payment Received", color = Color.White, fontSize = 14.sp)
                        Text("Today, 12:45 PM", color = TextGray, fontSize = 12.sp)
                    }
                    Text("+$240", color = SuccessGreen, fontWeight = FontWeight.Bold)
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Button(onClick = {}, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F3F4E))) {
                        Text("Send")
                    }
                    Button(onClick = {}, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F3F4E))) {
                        Text("Request")
                    }
                }
            }
        }
    }
}

@Composable
fun TransactionDetailItem(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, color = TextGray, fontSize = 14.sp)
        Text(text = value, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun TransactionSuccessScreen() {
    Column(
        modifier = Modifier.fillMaxSize().background(BackgroundDark).padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(16.dp))
            Text("Transaction", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Icono de Check en Box circular
        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .background(SuccessGreen.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.size(50.dp).clip(CircleShape).background(SuccessGreen),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Check, contentDescription = null, tint = BackgroundDark, modifier = Modifier.size(32.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Payment Successful", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Completed on Apr 23, 2026", color = TextGray, fontSize = 14.sp)

        Spacer(modifier = Modifier.height(32.dp))

        // Detalle del monto
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = CardDark),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Amount", color = TextGray, fontSize = 12.sp)
                Text("$240.00", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), color = Color.White.copy(alpha = 0.1f))
                Text("To", color = TextGray, fontSize = 12.sp)
                Text("Netflix Subscription", color = Color.White, fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        TransactionDetailItem("Transaction ID", "#A923756481")
        TransactionDetailItem("Payment Method", "Visa **** 4242")
        TransactionDetailItem("Date", "Apr 23, 2026")
        TransactionDetailItem("Status", "Completed")

        Spacer(modifier = Modifier.weight(1f))

        GradientButton(text = "Download Receipt")
        Spacer(modifier = Modifier.height(12.dp))
        TextButton(onClick = {}) {
            Text("Share", color = TextGray)
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PreviewTransaction() {
    TransactionSuccessScreen()
}

