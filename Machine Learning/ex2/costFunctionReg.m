function [J, grad] = costFunctionReg(theta, X, y, lambda)
%COSTFUNCTIONREG Compute cost and gradient for logistic regression with regularization
%   J = COSTFUNCTIONREG(theta, X, y, lambda) computes the cost of using
%   theta as the parameter for regularized logistic regression and the
%   gradient of the cost w.r.t. to the parameters. 

% Initialize some useful values
m = length(y); % number of training examples

% You need to return the following variables correctly 
J = 0;
grad = zeros(size(theta));

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the cost of a particular choice of theta.
%               You should set J to the cost.
%               Compute the partial derivatives and set grad to the partial
%               derivatives of the cost w.r.t. each parameter in theta
z= X*theta;
hypothesis =sigmoid(z);
temp1 = -y'*log(hypothesis);
temp2 = (1 - y)'* log(1-hypothesis);
J=((1/m)*( temp1-temp2));
theta(1)=0;
thetaSquare = theta'*theta;
J= J+ ((lambda/(2*m))*thetaSquare);
grad= (1/m)*(X'*(hypothesis-y)) + ((lambda/m)*theta);%X has size (m x n) and (h-y) has size (m x 1)





% =============================================================

end
